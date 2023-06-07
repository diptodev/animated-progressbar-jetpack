package com.excitedbroltd.animatedprogressbar

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun customProgress(
    canvasSize: Dp = 300.dp,
    progresVal: Float
) {
    Column(modifier = Modifier
        .size(canvasSize)
        .drawBehind {
            val componentSize = size / 1.25f
            drawBackground(componentSize, 60.4f, 240f)
            drawForeground(componentSize, 60.4f, progresVal)
        }) {

    }
}

fun DrawScope.drawBackground(componentSize: Size, indicatorStrokeWidth: Float, sweepAngel: Float) {
    drawArc(
        size = componentSize,
        useCenter = false,
        startAngle = 150f,
        sweepAngle = sweepAngel,
        color = Color.LightGray,
        style = Stroke(width = indicatorStrokeWidth, cap = StrokeCap.Round),
        topLeft = Offset(
            x = (size.width - componentSize.width) / 2f,
            y = (size.height - componentSize.height) / 2f
        )
    )
}

fun DrawScope.drawForeground(
    componentSize: Size,
    indicatorStrokeWidth: Float,
    sweepAngel: Float
) {
    drawArc(
        size = componentSize,
        startAngle = 150f,
        sweepAngle = sweepAngel,
        color = Color.Blue,
        style = Stroke(width = indicatorStrokeWidth, cap = StrokeCap.Round),
        useCenter = false,
        topLeft = Offset(
            x = (size.width - componentSize.width) / 2f,
            y = (size.height - componentSize.height) / 2f
        )
    )

}


@Composable
@Preview(showBackground = true)

fun showBackground() {
    customProgress(progresVal = 32f)
}