package ui

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun PlannerHomeScreen(
    uiState: PlannerUiState,
    onTaskCompleted: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.fillMaxSize().padding(24.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = "Welcome, ${uiState.studentName}",
            style = MaterialTheme.typography.headlineMedium
        )

        Text(
            text = "${uiState.completedTasks} of ${uiState.totalTasks} done",
            style = MaterialTheme.typography.bodyLarge
        )

        Button(
            onClick = onTaskCompleted,
            enabled = uiState.completedTasks < uiState.totalTasks
        ) {
            Text("Complete Task")
        }
    }
}

@Preview(showBackground = true, name = "Not done yet")
@Composable
private fun PlannerPreviewNotDone() {
    MaterialTheme {
        PlannerHomeScreen(
            uiState = PlannerUiState(studentName = "Student", totalTasks = 5, completedTasks = 0),
            onTaskCompleted = {}
        )
    }
}

@Preview(showBackground = true, name = "All done")
@Composable
private fun PlannerPreviewAllDone() {
    MaterialTheme {
        PlannerHomeScreen(
            uiState = PlannerUiState(studentName = "Student", totalTasks = 5, completedTasks = 5),
            onTaskCompleted = {}
        )
    }
}