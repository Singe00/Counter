package kr.ac.kumoh.ce.s20181131.w0403counter

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.modifier.modifierLocalOf
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kr.ac.kumoh.ce.s20181131.w0403counter.ui.theme.W0403CounterTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            W0403CounterTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    //Greeting("Android")
                    MyApp {
                        Column {
                            Counter()
                            Counter()
                            Counter()
                        }

                    }
                }
            }
        }
    }
}

@Composable
fun Counter() {
    var count by remember {
        mutableStateOf(0)
    }
    Column(modifier = Modifier
        //fillMaxSize()
        .padding(8.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "$count", fontSize = 70.sp)
        Row {
            Button(modifier = Modifier
                .weight(1f)
                .padding(2.dp), onClick = { count++}) {
                Text(text = "증가")
            }
            Button(modifier = Modifier
                .weight(1f)
                .padding(2.dp), onClick = { count--}) {
                Text(text = "감소")
            }
        }
    }
}

@Composable
fun MyApp(content: @Composable () -> Unit) {
    content()
}
@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    W0403CounterTheme {
        MyApp{
            Counter()
        }
    }
}