package com.amary.my.ocr.gemini.ui.component.dialog

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.amary.my.ocr.gemini.domain.model.OCRUiModel

@Composable
fun InfoDialog(
    isShowing: Boolean,
    data: OCRUiModel,
    onDismissRequest: () -> Unit = {}
) {
    if (isShowing) {
        Dialog(
            onDismissRequest = onDismissRequest,
            properties = DialogProperties(
                dismissOnBackPress = false,
                dismissOnClickOutside = false
            )
        ) {
            Surface(
                shape = RoundedCornerShape(8.dp),
                color = MaterialTheme.colorScheme.surface
            ) {
                Column(
                    modifier = Modifier.padding(20.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "Personal Data",
                        style = MaterialTheme.typography.titleLarge,
                    )

                    Column(
                        horizontalAlignment = Alignment.Start,
                        modifier = Modifier.padding(8.dp)
                    ) {
                        Text(
                            text = "NIK: ${data.nationalIdentityNumber}",
                            style = MaterialTheme.typography.bodyMedium
                        )
                        Text(
                            text = "Name: ${data.name}",
                            style = MaterialTheme.typography.bodyMedium
                        )
                        Text(
                            text = "Place/Date of Birth: ${data.placeAndDateOfBirth}",
                            style = MaterialTheme.typography.bodyMedium
                        )
                        Text(
                            text = "Gender: ${data.gender}",
                            style = MaterialTheme.typography.bodyMedium
                        )
                        Text(
                            text = "Address: ${data.address}",
                            style = MaterialTheme.typography.bodyMedium
                        )
                        Text(
                            text = "RT/RW: ${data.rtRw}",
                            style = MaterialTheme.typography.bodyMedium
                        )
                        Text(
                            text = "Village/Suburb: ${data.villageSuburb}",
                            style = MaterialTheme.typography.bodyMedium
                        )
                        Text(
                            text = "District: ${data.district}",
                            style = MaterialTheme.typography.bodyMedium
                        )
                        Text(
                            text = "Regency: ${data.regency}",
                            style = MaterialTheme.typography.bodyMedium
                        )
                        Text(
                            text = "Province: ${data.province}",
                            style = MaterialTheme.typography.bodyMedium
                        )
                        Text(
                            text = "Religion: ${data.religion}",
                            style = MaterialTheme.typography.bodyMedium
                        )
                        Text(
                            text = "Marital Status: ${data.maritalStatus}",
                            style = MaterialTheme.typography.bodyMedium
                        )
                        Text(
                            text = "Occupation: ${data.occupation}",
                            style = MaterialTheme.typography.bodyMedium
                        )
                        Text(
                            text = "Citizenship: ${data.citizenship}",
                            style = MaterialTheme.typography.bodyMedium
                        )
                    }
                    Spacer(modifier = Modifier.height(16.dp))
                    Button(
                        onClick = onDismissRequest,
                        modifier = Modifier.padding(top = 16.dp)
                    ) {
                        Text("Close")
                    }
                }
            }
        }
    }
}