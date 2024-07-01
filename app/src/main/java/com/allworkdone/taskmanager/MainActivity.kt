package com.allworkdone.taskmanager

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.allworkdone.taskmanager.ui.theme.TaskManagerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TaskManagerTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    TaskManagerApp(
//                        Stringify the string resource
                        heading = stringResource(R.string.heading),
                        content = stringResource(R.string.content),
                        modifier = Modifier
                            .padding(innerPadding)

                    )
                }
            }
        }
    }
}

@Composable
fun TaskManagerApp(heading: String,content: String, modifier: Modifier=Modifier) {
//    Inserted the image
    val image = painterResource(id = R.drawable.ic_task_completed)
//    wrapped the items in the column
    Column(modifier = modifier.padding(16.dp)
        //        fill the screen
        .fillMaxSize(),
//        arranging the items in the column
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
        ) {
        Image(painter = image, contentDescription = null)
        TaskManagerText(
            heading = heading,
            content = content,
            modifier = Modifier

        )
    }
}

@Composable
fun TaskManagerText(heading: String,content: String, modifier: Modifier = Modifier) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(
            text = heading,
            modifier = modifier.padding(top = 24.dp, bottom = 8.dp),
            fontWeight = FontWeight.Bold,
        )
        Text(
            text = content,
            modifier = modifier,
            fontSize = 16.sp
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    TaskManagerTheme {
        TaskManagerApp(stringResource(R.string.heading), stringResource(R.string.content))
    }
}