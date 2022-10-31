/*
package com.example.lemonade

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lemonade.ui.theme.LemonadeTheme
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LemonadeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    LemonadeWithButtonAndImage()
                }
            }
        }
    }
}
/*
@Composable
fun LemonadeWithImages(){
    val treeimage = painterResource(id = R.drawable.lemon_tree)
    val lemonimage = painterResource(id = R.drawable.lemon_squeeze)
    val drinkimage = painterResource(id = R.drawable.lemon_drink)
    val restartimage = painterResource(id = R.drawable.lemon_restart)

    Image(
        painter = treeimage,
        contentDescription = "1"
    )
    Image(
        painter = lemonimage,
        contentDescription = "1"
    )
    Column(modifier = modifier, horizontalAlignment = Alignment.CenterHorizontally) {
        Image(painter = painterResource(imageResource), contentDescription = result.toString())
        Spacer(modifier = Modifier.height(1.dp))
        Button(onClick = { result = (1..6).random() }) {
            Text(text = stringResource(androidx.compose.foundation.layout.R.string.roll), fontSize = 24.sp)


}
*/
        @Composable
        fun LemonadeWithButtonAndImage(modifier: Modifier = Modifier) {
    var result by remember { mutableStateOf(1) }
    var count = 0
    val imageResource = when (result) {
        1 -> R.drawable.lemon_tree
        2 -> R.drawable.lemon_squeeze
        3 -> R.drawable.lemon_drink
        else -> R.drawable.lemon_restart
    }
    Column(modifier = modifier, horizontalAlignment = Alignment.CenterHorizontally) {
        if (result == 1) {
            Button(onClick = { result = (2..2).random() }) {
                Box {
                    Text(
                        text = stringResource(R.string.lemon_tree),
                        textAlign = TextAlign.Center,
                        fontSize = 30.sp,
                        modifier = Modifier
                            .padding(top = 100.dp, bottom = 50.dp)
                            .border(width = 2.dp, color = Color.Green)
                    )
                }
            }
        }
    }

    Image(
        painter = painterResource(imageResource),
        alignment = Alignment.Center,
        contentDescription = result.toString(),
        modifier = Modifier
            .padding(top = 250.dp, start = 70.dp)
            .height(100.dp)
            .width(100.dp)
    )
    Spacer(modifier = Modifier.height(1.dp))
    when (count) {
        if (result == 2) {
            Button(onClick = { result = (2..2).random() }) {
                Box {
                    Text(
                        text = stringResource(R.string.lemon_squeeze),
                        textAlign = TextAlign.Center,
                        fontSize = 30.sp,
                        modifier = Modifier
                            .padding(top = 1.dp, bottom = 50.dp)
                            .border(width = 2.dp, color = Color.Green)
                    )
                }
            }



            Image(
                painter = painterResource(imageResource),
                alignment = Alignment.Center,
                contentDescription = result.toString(),
                modifier = Modifier
                    .padding(top = 200.dp, start = 70.dp)
                    .height(100.dp)
                    .width(100.dp)
            )
            Spacer(modifier = Modifier.height(1.dp))

            else ->
            Image(
                painter = painterResource(imageResource),
                alignment = Alignment.Center,
                contentDescription = result.toString(),
                modifier = Modifier
                    .padding(top = 200.dp, start = 70.dp)
                    .height(100.dp)
                    .width(100.dp)
            )
        }
            else ->
            {
                Image(
                    painter = painterResource(imageResource),
                    alignment = Alignment.Center,
                    contentDescription = result.toString(),
                    modifier = Modifier
                        .padding(top = 200.dp, start = 70.dp)
                        .height(100.dp)
                        .width(100.dp)
                )
    }
}
}


@Preview
@Composable
fun LemonadeApp(){
    LemonadeTheme {
        LemonadeWithButtonAndImage()

    }
}

*/


package com.example.lemonade

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lemonade.ui.theme.LemonadeTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LemonadeTheme {
                LemonApp()
                BackgroundImage()
            }
        }
    }
}


@Composable
fun LemonTextAndImage(
    textLabelResourceId: Int,
    drawableResourceId: Int,
    contentDescriptionResourceId: Int,
    onImageClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = modifier.fillMaxSize()
    ) {
        Text(
            text = stringResource(textLabelResourceId),
            fontSize = 18.sp,
            modifier = Modifier.border(width = 1.dp, color = Color.Green )

        )
        Spacer(modifier = Modifier.height(16.dp))
        Image(
            painter = painterResource(drawableResourceId),
            contentDescription = stringResource(contentDescriptionResourceId),
            modifier = Modifier
                .wrapContentSize()
                .clickable(
                    onClick = onImageClick
                )
                .border(
                    BorderStroke(2.dp, Color(105, 205, 216)),
                    shape = RoundedCornerShape(4.dp)
                )
                .padding(16.dp)
        )
    }
}



@Composable
fun LemonApp() {

    // Current step the app is displaying (remember allows the state to be retained
    // across recompositions).
    var ClickOption by remember { mutableStateOf(1) }

    // Number of times the lemon needs to be squeezed to turn into a glass of lemonade
    var Counter by remember { mutableStateOf(0) }

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colors.background
    ) {
        when (ClickOption) {
            1 -> {
                // Display lemon tree image and ask user to pick a lemon from the tree
                LemonTextAndImage(
                    textLabelResourceId = R.string.lemon_select,
                    drawableResourceId = R.drawable.lemon_tree,
                    contentDescriptionResourceId = R.string.lemon_tree_content_description,
                    onImageClick = {
                        // Update to next step
                        ClickOption = 2
                        // Each time a lemon is picked from the tree, get a new random number
                        // between 2 and 5 (inclusive) for the number of times the lemon needs
                        // to be squeezed to turn into lemonade
                        Counter = (2..5).random()
                    }
                )
            }
            2 -> {
                // Display lemon image and ask user to squeeze the lemon
                LemonTextAndImage(
                    textLabelResourceId = R.string.lemon_squeeze,
                    drawableResourceId = R.drawable.lemon_squeeze,
                    contentDescriptionResourceId = R.string.lemon_content_description,
                    onImageClick = {
                        // Decrease the squeeze count by 1 for each click the user performs
                        Counter--
                        // When we're done squeezing the lemon, move to the next step
                        if (Counter == 0) {
                            ClickOption = 3
                        }
                    }
                )
            }
            3 -> {
                // Display glass of lemonade image and ask user to drink the lemonade
                LemonTextAndImage(
                    textLabelResourceId = R.string.lemon_drink,
                    drawableResourceId = R.drawable.lemon_drink,
                    contentDescriptionResourceId = R.string.lemonade_content_description,
                    onImageClick = {
                        // Update to next step
                        ClickOption = 4
                    }
                )
            }
            4 -> {
                // Display empty glass image and ask user to start again
                LemonTextAndImage(
                    textLabelResourceId = R.string.lemon_empty_glass,
                    drawableResourceId = R.drawable.lemon_restart,
                    contentDescriptionResourceId = R.string.empty_glass_content_description,
                    onImageClick = {
                        // Back to starting step
                        ClickOption = 1
                    }
                )
            }
        }
    }
}

/**
 * Composable that displays a text label above an image that is clickable.
 *
 * @param textLabelResourceId is the resource ID for the text string to display
 * @param drawableResourceId is the resource ID for the image drawable to display below the text
 * @param contentDescriptionResourceId is the resource ID for the string to use as the content
 * description for the image
 * @param onImageClick will be called when the user clicks the image
 * @param modifier modifiers to set to this composable
 */


@Composable
fun BackgroundImage(){
    val image = painterResource(id = R.drawable.background)
    Column {
        Image(
            painter = image,
            alignment = Alignment.Center,
            contentDescription = null ,
            modifier = Modifier
                .height(800.dp)
                .width(1000.dp)
                .padding(top=0.dp)

            //.fillMaxSize()
            //.fillMaxHeight()

        )
    }
}


@Preview
@Composable
fun LemonPreview() {
    LemonadeTheme {
        LemonApp()
        BackgroundImage()
    }
}