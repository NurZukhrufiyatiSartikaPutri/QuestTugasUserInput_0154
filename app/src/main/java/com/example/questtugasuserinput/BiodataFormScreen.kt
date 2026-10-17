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

    val experienceOptions = listOf("< 1 tahun", "1 - 3 tahun", "> 3 tahun")
    val scrollState = rememberScrollState()

    Box(modifier = modifier.fillMaxSize().background(colorResource(id = R.color.white))) {
        // Top Background Image
        Image(
            painter = painterResource(id = R.drawable.gambar),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp),
            contentScale = ContentScale.Crop
        )

        // Floating Card / Box over Scaffold
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(scrollState)
        ) {
            Spacer(modifier = Modifier.height(200.dp))

            Surface(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight(),
                shape = RoundedCornerShape(topStart = 32.dp, topEnd = 32.dp),
                color = colorResource(id = R.color.white),
                shadowElevation = 8.dp
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(24.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = stringResource(id = R.string.form_title),
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold,
                        color = colorResource(id = R.color.purple_heading)
                    )

                    Spacer(modifier = Modifier.height(4.dp))

                    Text(
                        text = stringResource(id = R.string.form_subtitle),
                        fontSize = 12.sp,
                        color = colorResource(id = R.color.teal_700)
                    )

                    Spacer(modifier = Modifier.height(24.dp))

                    // Nama Depan & Nama Belakang
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        OutlinedTextField(
                            value = namaDepan,
                            onValueChange = { namaDepan = it },
                            label = { Text(stringResource(id = R.string.nama_depan)) },
                            modifier = Modifier.weight(1f),
                            shape = RoundedCornerShape(16.dp),
                            singleLine = true
                        )

                        OutlinedTextField(
                            value = namaBelakang,
                            onValueChange = { namaBelakang = it },
                            label = { Text(stringResource(id = R.string.nama_belakang)) },
                            modifier = Modifier.weight(1f),
                            shape = RoundedCornerShape(16.dp),
                            singleLine = true
                        )
                    }

                    Spacer(modifier = Modifier.height(16.dp))

                    // Email
                    OutlinedTextField(
                        value = email,
                        onValueChange = { email = it },
                        label = { Text(stringResource(id = R.string.email)) },
                        modifier = Modifier.fillMaxWidth(),
                        shape = RoundedCornerShape(16.dp),
                        singleLine = true
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    // Tgl Lahir & Experience
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        // Tgl Lahir Field
                        Box(
                            modifier = Modifier
                                .weight(1f)
                                .clickable { showDatePicker = true }
                        ) {
                            OutlinedTextField(
                                value = tglLahir,
                                onValueChange = { },
                                readOnly = true,
                                enabled = true,
                                label = { Text(stringResource(id = R.string.tgl_lahir)) },
                                trailingIcon = {
                                    IconButton(onClick = { showDatePicker = true }) {
                                        Icon(
                                            imageVector = Icons.Default.DateRange,
                                            contentDescription = null,
                                            tint = colorResource(id = R.color.purple_heading)
                                        )
                                    }
                                },
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .clickable { showDatePicker = true },
                                shape = RoundedCornerShape(16.dp),
                                singleLine = true
                            )
                        }

                        // Experience Dropdown Field
                        Box(
                            modifier = Modifier
                                .weight(1f)
                                .clickable { expandedExperience = !expandedExperience }
                        ) {
                        }
                    }
                }
            }
        }
    }
}