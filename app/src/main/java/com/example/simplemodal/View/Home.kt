package com.example.simplemodal.View

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Home() {
    var openBottomSheet by rememberSaveable { mutableStateOf(false) }
    var skipPartiallyExpanded by remember { mutableStateOf(false) }
    val scope = rememberCoroutineScope()
    val bottomSheetState = rememberModalBottomSheetState(
        skipPartiallyExpanded = skipPartiallyExpanded
    )

    // Main content
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Home screen")
        Button(onClick = {
            scope.launch {
                openBottomSheet = true
            }
        }) {
            Text(text = "Open bottom sheet")
        }
    }
    // Bottom sheet content
    if (openBottomSheet) {
        ModalBottomSheet(
            //modifier = Modifier.padding(top = 16.dp),
            modifier = Modifier.fillMaxSize(),
            onDismissRequest = {openBottomSheet = false },
            sheetState = bottomSheetState,
        ) {
            Column(
                modifier = Modifier.padding(start = 16.dp, bottom = 24.dp)
            ) {
                Text("modal bottom content1")
                Text("modal bottom content2")
                Text("modal bottom content3")
                Text("modal bottom content4")
            }
        }
    }
}