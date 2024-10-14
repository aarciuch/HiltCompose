import android.util.Log
import androidx.compose.foundation.content.MediaType.Companion.Text
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import tm.lab.hiltcompose.vm.PersonsViewModel

@Composable
fun AddScreen(navController: NavController, text: String?, modifier: Modifier = Modifier, viewModel: PersonsViewModel = hiltViewModel()) {
    Text(text = "${text}")
}

