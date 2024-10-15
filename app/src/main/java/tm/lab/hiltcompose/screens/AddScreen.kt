import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.content.MediaType.Companion.Text
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import tm.lab.hiltcompose.db.Persons
import tm.lab.hiltcompose.vm.PersonsViewModel

@Composable
fun AddScreen(navController: NavController, text: String?, modifier: Modifier = Modifier, viewModel: PersonsViewModel = hiltViewModel()) {
    var name1 by remember { mutableStateOf("") }
    var age1 by remember { mutableStateOf(0) }
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .background(color = Color(255, 255, 0))
    )
    {
        Row ()
        {
            Text(text = "${text}")
        }
        Row ()
        {
            TextField(
                value = name1,
                onValueChange = {
                    name1 = it
                },
                label = { Text("person name:") }
            )
        }
        Row ()
        {
            TextField(
                keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number),
                value = age1.toString(),
                onValueChange = {
                    if (!it.isEmpty())
                        age1 = it.toInt()
                },
                label = { Text("person age:") }
            )
        }
        Row() {
            Button(onClick = {
                viewModel.savePerson(Persons(0,name1, age1))
                navController.navigate(route = Screen.Main.name)
            })
            {
                Text(text="Add person and go back")
            }
        }
    }
}