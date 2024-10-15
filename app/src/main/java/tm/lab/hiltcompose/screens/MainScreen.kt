import android.inputmethodservice.Keyboard
import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.AbsoluteAlignment
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.motionEventSpy
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import tm.lab.hiltcompose.vm.PersonsViewModel


@Composable
fun MainScreen(navController: NavController, name: String, modifier: Modifier = Modifier, viewModel: PersonsViewModel = hiltViewModel()) {
    val personsList = viewModel.personsUiState.collectAsState().value.persons
    var param1 by remember { mutableStateOf("person adding") }
    Log.i("PERSON", "$personsList")
    Column(modifier = Modifier
        .fillMaxWidth()
        .fillMaxHeight()
        .padding(8.dp)
        .background(Color(162, 231, 222, 255))
    ){
        Text(modifier = Modifier
                .padding(top = 8.dp)
                .fillMaxWidth(),
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            text = "Hello $name!"
        )
        Row {
            Button(modifier = Modifier
                .weight(1f)
                .padding(8.dp),
                onClick = { navController.navigate(route = Screen.Add.name + "?text=${param1}") }
            ) {
                Text(text = "Go to add person")
            }
            Button(modifier = Modifier
                .weight(1f)
                .padding(8.dp),
                onClick = { viewModel.clearPersons() }
            ) {
                Text(text = "Clear DB")
            }
        }
        LazyColumn(
            modifier = Modifier
               // .background(color = Color.Green)
                .padding(16.dp)
                //.height(400.dp)
                .fillMaxWidth()
                //.fillMaxHeight()
        ) {
            items(personsList) { person ->
                LazyRow(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(color = Color.Red)
                        .padding(2.dp)
                        .border(1.dp, MaterialTheme.colorScheme.secondary),
                ) {
                    item {
                        Text(
                            modifier = Modifier
                                .width(180.dp)
                                .padding(top = 16.dp, start = 8.dp)
                                .background(color = Color.Yellow),
                            fontSize = 30.sp,
                            fontWeight = FontWeight.Bold,
                            textAlign = TextAlign.Center,
                            text = "${person.name},${person.age}"
                        )
                        Button(
                            modifier = Modifier
                                .padding(start = 10.dp, end = 8.dp, top = 8.dp, bottom = 8.dp),
                            onClick = { viewModel.deletePersonById(person.id) },
                        ) {
                            Text(text = "delete person")
                        }
                    }
                }
            }
        }
    }
}