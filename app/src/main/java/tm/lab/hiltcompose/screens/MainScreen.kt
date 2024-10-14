import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import tm.lab.hiltcompose.vm.PersonsViewModel


@Composable
fun MainScreen(navController: NavController, name: String, modifier: Modifier = Modifier, viewModel: PersonsViewModel = hiltViewModel()) {
    val personsList = viewModel.personsUiState.collectAsState().value.persons
    Log.i("PERSON", "$personsList")
    LazyColumn(modifier = Modifier
        .height(300.dp)
        .background(color = Color.Yellow)
        .padding(16.dp)
    ){
        item {
            Text(
                text = "Hello $name!",
                modifier = modifier
            )
        }
        items(personsList) { person ->
            Row (modifier = Modifier
                .fillMaxWidth()
                .background(color = Color.Red)
                .padding(2.dp)
                .border(1.dp, MaterialTheme.colorScheme.secondary),

                ) {
                Text(modifier = Modifier
                    .fillMaxWidth()
                    .padding(4.dp)
                    .background(color = Color.Yellow),
                    text = "${person.id}, ${person.name}, ${person.age}"
                )
            }
        }
        item {
            Button(modifier = Modifier,
                onClick = {navController.navigate(route = Screen.Add.route + "?text=${"Ala ma kota"}")}) {
                Text(text = "Go to add person")
            }
        }
    }
}