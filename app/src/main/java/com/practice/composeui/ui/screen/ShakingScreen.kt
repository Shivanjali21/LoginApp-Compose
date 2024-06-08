package com.practice.composeui.ui.screen

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.AnimationSpec
import androidx.compose.animation.core.tween
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.graphicsLayer

class ShakingState(private val strength: Strength, private val directions: Directions) {

    val xPosition = Animatable(0f)
    suspend fun shake(animDuration: Int = 50) {
        val shakeAnimSpec: AnimationSpec<Float> = tween(animDuration)
        when (directions) {
            Directions.LEFT -> shakeToLeft(shakeAnimSpec)
            Directions.LEFT_THEN_RIGHT -> shakeToRight(shakeAnimSpec)
            Directions.RIGHT -> shakeToLeftThenRight(shakeAnimSpec)
            Directions.RIGHT_THEN_LEFT -> shakeToRightThenLeft(shakeAnimSpec)
        }
    }

    private suspend fun shakeToLeft(shakeAnimSpec: AnimationSpec<Float>) {
        repeat(3){
            xPosition.animateTo(-strength.value, shakeAnimSpec)
            xPosition.animateTo(0f, shakeAnimSpec)
        }
    }

    private suspend fun shakeToLeftThenRight(shakeAnimSpec: AnimationSpec<Float>) {
        repeat(3){
            xPosition.animateTo(-strength.value, shakeAnimSpec)
            xPosition.animateTo(0f, shakeAnimSpec)
            xPosition.animateTo(strength.value / 2, shakeAnimSpec)
            xPosition.animateTo(0f, shakeAnimSpec)
        }
    }

    private suspend fun shakeToRight(shakeAnimSpec: AnimationSpec<Float>) {
        repeat(3){
            xPosition.animateTo(-strength.value, shakeAnimSpec)
            xPosition.animateTo(0f, shakeAnimSpec)
            xPosition.animateTo(strength.value / 2, shakeAnimSpec)
            xPosition.animateTo(0f, shakeAnimSpec)
        }
    }

    private suspend fun shakeToRightThenLeft(shakeAnimSpec: AnimationSpec<Float>) {
        xPosition.animateTo(strength.value, shakeAnimSpec)
        xPosition.animateTo(0f, shakeAnimSpec)
        xPosition.animateTo(-strength.value / 2, shakeAnimSpec)
        xPosition.animateTo(0f, shakeAnimSpec)
    }

    sealed class Strength(val value: Float) {
        data object Normal : Strength(17f)
        data object String : Strength(40f)
        data class Custom(val strength: Float) : Strength(strength)
    }

    enum class Directions {
        LEFT, RIGHT, LEFT_THEN_RIGHT, RIGHT_THEN_LEFT
    }
}

@Composable
fun rememberShakeButton(strength: ShakingState.Strength = ShakingState.Strength.Normal,
                        directions: ShakingState.Directions = ShakingState.Directions.LEFT) : ShakingState {
    return remember {
        ShakingState(strength = strength, directions = directions)
    }
}

fun Modifier.shakable(
 state: ShakingState
) : Modifier {
  return graphicsLayer {
    translationX = state.xPosition.value
  }
}