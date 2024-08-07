package nextstep.signup

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import nextstep.signup.ui.theme.SignupTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SignupTheme {

            }
        }
    }
}

@Composable
fun HelloView(
    name: String, modifier: Modifier = Modifier
) {
    Text(
        text = "Hello $name!", modifier = modifier.background(
            brush = Brush.linearGradient(
                colors = listOf(Color.Red, Color.Green),
                start = Offset.Zero,
            )
        ), fontSize = 20.sp, color = Color.White
    )
}

@Preview(showBackground = true)
@Composable
fun HelloViewPreview(modifier: Modifier = Modifier) {
    HelloView(name = "simuelunbo")
}