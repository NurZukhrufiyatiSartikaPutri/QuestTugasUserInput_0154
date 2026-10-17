package com.example.questtugasuserinput

import android.app.DatePickerDialog
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.questtugasuserinput.ui.theme.QuestTugasUserInputTheme
import java.util.Calendar
import androidx.compose.foundation.layout.navigationBarsPadding

@Composable
fun BiodataFormScreen(modifier: Modifier = Modifier) {
    var namaDepan by remember { mutableStateOf("") }
    var namaBelakang by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var tglLahir by remember { mutableStateOf("") }
    var experience by remember { mutableStateOf("") }

    var androidChecked by remember { mutableStateOf(false) }
    var uiUxChecked by remember { mutableStateOf(false) }
    var webChecked by remember { mutableStateOf(false) }

    var isSubmitted by remember { mutableStateOf(false) }
    var expandedExperience by remember { mutableStateOf(false) }
    var showDatePicker by remember { mutableStateOf(false) }

    val context = LocalContext.current
    val calendar = Calendar.getInstance()
    val year = calendar.get(Calendar.YEAR)
    val month = calendar.get(Calendar.MONTH)
    val day = calendar.get(Calendar.DAY_OF_MONTH)

    if (showDatePicker) {
        LaunchedEffect(showDatePicker) {
            val dialog = DatePickerDialog(
                context,
                { _, selectedYear, selectedMonth, selectedDay ->
                    tglLahir = "$selectedDay/${selectedMonth + 1}/$selectedYear"
                    showDatePicker = false
                },
                year, month, day
            )
            dialog.setOnCancelListener { showDatePicker = false }
            dialog.setOnDismissListener { showDatePicker = false }
            dialog.show()
        }
    }

}
