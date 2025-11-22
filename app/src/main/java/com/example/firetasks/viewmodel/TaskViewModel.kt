package com.example.firetasks // Troque pelo nome do seu pacote

import androidx.lifecycle.ViewModel
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class TaskViewModel : ViewModel() {
    private val db = FirebaseFirestore.getInstance()

    private val _tasks = MutableStateFlow<List<Task>>(emptyList())
    val tasks: StateFlow<List<Task>> = _tasks

    init {
        fetchTasks()
    }

    // LER (Read): Escuta atualizações em tempo real do Firestore
    private fun fetchTasks() {
        db.collection("tasks")
            .addSnapshotListener { snapshot, error ->
                if (error != null) {
                    return@addSnapshotListener
                }
                if (snapshot != null) {
                    val taskList = snapshot.documents.map { doc ->
                        Task(
                            id = doc.id,
                            title = doc.getString("title") ?: "",
                            isCompleted = doc.getBoolean("isCompleted") ?: false
                        )
                    }
                    _tasks.value = taskList
                }
            }
    }

    // CRIAR (Create): Adiciona nova tarefa
    fun addTask(title: String) {
        val taskMap = hashMapOf(
            "title" to title,
            "isCompleted" to false
        )
        db.collection("tasks").add(taskMap)
    }

    // ATUALIZAR (Update): Alterna entre concluído/pendente
    fun toggleTaskStatus(task: Task) {
        db.collection("tasks").document(task.id)
            .update("isCompleted", !task.isCompleted)
    }

    // EXCLUIR (Delete): Remove a tarefa do banco
    fun deleteTask(taskId: String) {
        db.collection("tasks").document(taskId).delete()
    }
}