package ru.itis.itis_android_inception_24.screens.composeSample.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.material.Divider
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.itis.itis_android_inception_24.R
import ru.itis.itis_android_inception_24.model.AnswerModel

@Composable
fun HeaderTextInput() {
    var textValue = remember { "" }

    Column {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(24.dp)
                .padding(start = 16.dp, end = 16.dp)
                .background(Color.Green)
                .clickable {

                }
        )

        TextField(
            value = textValue,
            onValueChange = { input ->
                textValue = input
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp, end = 16.dp)
        )
    }
}

@Composable
fun ComposeListSample(
    listState: LazyListState,
    items: List<AnswerModel>,
) {
    LazyColumn(state = listState) {
        item {
            Text(
                text = "List beginning",
                fontSize = 32.sp,
                modifier = Modifier.padding(16.dp)
            )
        }

        items(count = items.size) { position ->
            Column {
                ListItemSample(items[position])
                if (position != items.size - 1) {
                    Divider()
                }
            }
        }

        item {
            Text(
                text = stringResource(R.string.chooser_title),
                color = colorResource(R.color.teal_200),
                fontSize = 32.sp,
            )
        }
    }
}

@Composable
fun ListItemSample(model: AnswerModel) {
    Row {
        Text(
            text = model.answerText,
            modifier = Modifier.size(80.dp)
        )
        Text(
            text = model.answerId,
            modifier = Modifier.size(80.dp)
        )
    }
}