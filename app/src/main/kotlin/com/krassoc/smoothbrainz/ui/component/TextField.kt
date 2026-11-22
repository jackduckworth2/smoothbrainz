package com.krassoc.smoothbrainz.ui.component

import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.input.TextFieldLineLimits
import androidx.compose.foundation.text.input.TextFieldState
import androidx.compose.foundation.text.input.rememberTextFieldState
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TextFieldLabelPosition
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

import com.krassoc.smoothbrainz.ui.theme.MyApplicationTheme

@Composable
fun AppOutlinedTextField(
    label: String,
    placeholder: String,
    state: TextFieldState,
    enabled: Boolean = true,
) {
    OutlinedTextField(
        state = state,
        enabled = enabled,
        label = { Text(label) },
        placeholder = { Text(placeholder) },
        lineLimits = TextFieldLineLimits.SingleLine,
        modifier = Modifier.fillMaxWidth().padding(20.dp),
        shape = OutlinedTextFieldDefaults.roundedShape,
        colors = OutlinedTextFieldDefaults.tonalColors(),
        labelPosition = TextFieldLabelPosition.Inside(),
        textStyle = TextStyle(color = Color.Blue,
        fontWeight = FontWeight.Bold),
    )
}

@Preview("TAppOutlinedTextField")
@Composable
private fun AppOutlinedTextFieldPreview() {
    MyApplicationTheme {
        AppOutlinedTextField(
            label ="Email Address",
            placeholder = "example@domain.com",
            state = rememberTextFieldState(),
        )
    }
}

@Composable
fun AppTextField(
    label: String,
    placeholder: String,
    state: TextFieldState,
    enabled: Boolean = true,
) {
    TextField(
        state = state,
        enabled = enabled,
        label = { Text(label) },
        placeholder = { Text(placeholder) },
        lineLimits = TextFieldLineLimits.SingleLine,
        modifier = Modifier.fillMaxWidth().padding(20.dp),
        shape = TextFieldDefaults.roundedShape,
        colors = TextFieldDefaults.tonalColors(),
        textStyle = TextStyle(color = Color.Blue,
        fontWeight = FontWeight.Bold),
    )
}

@Preview("AppTextFieldPreview")
@Composable
private fun AppTextFieldPreview() {
    MyApplicationTheme {
        AppTextField(
            label ="Email Address",
            placeholder = "example@domain.com",
            state = rememberTextFieldState(),
        )
    }
}

@Composable
fun EnhancedCapsuleTextFieldTemplate() {
    var textState by remember { mutableStateOf(TextFieldValue("")) }
    var isFocused by remember { mutableStateOf(false) }
    var isError by remember { mutableStateOf(false) }  // Set this based on validation logic
    var isSuccess by remember { mutableStateOf(false) }  // Set this based on validation logic

    // Dynamic border color based on state (error, success, focus)
    val borderColor by animateColorAsState(
        targetValue = when {
            isError -> Color.Red
            isSuccess -> Color(0xFF4CAF50) // Green color for success
            isFocused -> Color.Black
            else -> Color.Gray
        }
    )

    // Dynamic text color
    val textColor by animateColorAsState(
        targetValue = if (isError) Color.Red else Color.Black
    )

    // Wrapping container with padding, shadow, and background gradient
    Box(
        modifier = Modifier
            .fillMaxWidth(),
        // .padding(16.dp)
        //  .zIndex(1f), // Ensures it's above other content
        contentAlignment = Alignment.TopStart
    ) {
        // Card container for the capsule TextField
        Card(
            shape = RoundedCornerShape(30.dp),
            elevation = CardDefaults.cardElevation(12.dp), // Enhanced shadow
            colors = CardDefaults.cardColors(
                containerColor = Color(0xFFF5F5F5) // Light background
            ),
            modifier = Modifier
                .fillMaxWidth()
            //  .padding(8.dp)
        ) {

            // Capsule-shaped BasicTextField with enhancements
            BasicTextField(
                value = textState,
                onValueChange = {
                    textState = it
                    // Add logic for error or success validation
                    isError = textState.text.length < 3 // Example validation for error
                    isSuccess = textState.text.length >= 3 // Example validation for success
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp)
                    .background(
                        brush = Brush.horizontalGradient(
                            listOf(Color(0xFFBBDEFB), Color(0xFFE3F2FD))
                        ),
                        shape = CircleShape
                    )
                    .border(
                        width = 2.dp,
                        color = borderColor,
                        shape = CircleShape
                    )
                    .onFocusChanged { focusState ->
                        isFocused = focusState.isFocused
                    }
                    .padding(
                        horizontal = 16.dp,
                        vertical = 8.dp
                    ), // Internal padding for a better look
                cursorBrush = SolidColor(if (isError) Color.Red else Color.Blue),
                textStyle = TextStyle(
                    color = textColor,
                    fontSize = 16.sp,
                    textAlign = TextAlign.Start,  // Align text to the start (left)
                    shadow = Shadow(color = Color.Gray, blurRadius = 1f) // Subtle shadow for text
                ),
                decorationBox = { innerTextField ->
                    Box(
                        contentAlignment = Alignment.CenterStart,
                        modifier = Modifier.fillMaxSize()
                    ) {
                        if (textState.text.isEmpty()) {
                            Text(
                                text = "Enter your text here...",
                                color = Color.Gray,
                                fontSize = 16.sp,
                                textAlign = TextAlign.Start // Placeholder text aligned to the start
                            )
                        }
                        innerTextField() // The actual text field
                    }
                }
            )
        }
    }
}

@Preview("EnhancedCapsuleTextField")
@Composable
private fun EnhancedCapsuleTextFieldTemplatePreview() {
    MyApplicationTheme {
        EnhancedCapsuleTextFieldTemplate(
        )
    }
}

@Composable
fun EnhancedCapsuleTextField(placeholder: String, ) {
    var textState by remember { mutableStateOf(TextFieldValue("")) }
    val borderColor = Color(0xFF4CAF50) // Green color for success
    val textColor    = Color.Black

    // Capsule-shaped BasicTextField with enhancements
    BasicTextField(
        value = textState,
        onValueChange = { textState = it },
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp)
            .background(
                brush = Brush.horizontalGradient(
                    listOf(Color(0xFFBBDEFB), Color(0xFFE3F2FD))
                ),
                shape = CircleShape
            )
            .border(
                width = 2.dp,
                color = borderColor,
                shape = CircleShape
            )
            .padding(
                horizontal = 16.dp,
                vertical = 8.dp
            ), // Internal padding for a better look
        cursorBrush = SolidColor(Color.Blue),
        textStyle = TextStyle(
            color = textColor,
            fontSize = 16.sp,
            textAlign = TextAlign.Start,  // Align text to the start (left)
            shadow = Shadow(color = Color.Gray, blurRadius = 1f) // Subtle shadow for text
        ),
        decorationBox = { innerTextField ->
            Box(
                contentAlignment = Alignment.CenterStart,
                modifier = Modifier.fillMaxSize()
            ) {
                if (textState.text.isEmpty()) {
                    Text(
                        text = placeholder,
                        color = Color.Gray,
                        fontSize = 16.sp,
                        textAlign = TextAlign.Start // Placeholder text aligned to the start
                    )
                }
                innerTextField() // The actual text field
            }
        }
    )
}

@Preview("EnhancedCapsuleTextField")
@Composable
private fun EnhancedCapsuleTextFieldPreview() {
    MyApplicationTheme {
        EnhancedCapsuleTextField(
            placeholder = "Enter your text here...",
       )
    }
}

