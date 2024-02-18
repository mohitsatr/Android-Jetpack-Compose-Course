package com.example.mycity.ui

import androidx.lifecycle.ViewModel
import com.example.mycity.data.Category
import com.example.mycity.data.City
import com.example.mycity.data.MyCityUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

/*
 * Copyright (C) 2023 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
//package com.example.reply.ui
//
//import androidx.lifecycle.ViewModel
//import com.example.reply.data.Email
//import com.example.reply.data.MailboxType
//import com.example.reply.data.local.LocalEmailsDataProvider
//import kotlinx.coroutines.flow.MutableStateFlow
//import kotlinx.coroutines.flow.StateFlow
//import kotlinx.coroutines.flow.update
//

class MyCityViewModel : ViewModel(){
    private val _uiState = MutableStateFlow(MyCityUiState())
    val uiState: StateFlow<MyCityUiState> = _uiState


    fun setScreen(category: Category){
        _uiState.update {
            currentState -> currentState.copy(
                currentPlace = category
            )
        }
    }

    fun setCurrentCity(name: City) {
        _uiState.update {
            currentState -> currentState.copy(currentCity = name)
        }

    }
    fun setListofPlaces(){
        _uiState.update {
            current -> current.copy(PlacesList = current.currentCity.map[current.currentPlace])
        }

    }
}
//class MyCityViewModel : ViewModel() {
//
//    private val _uiState = MutableStateFlow(ReplyUiState())
//
//    init {
//        initializeUIState()
//    }
//
//    private fun initializeUIState() {
//        val mailboxes: Map<MailboxType, List<Email>> =
//            LocalEmailsDataProvider.allEmails.groupBy { it.mailbox }
//        _uiState.value =
//            ReplyUiState(
//                mailboxes = mailboxes,
//                currentSelectedEmail = mailboxes[MailboxType.Inbox]?.get(0)
//                    ?: LocalEmailsDataProvider.defaultEmail
//            )
//    }
//
//    fun updateDetailsScreenStates(email: Email) {
//        _uiState.update {
//            it.copy(
//                currentSelectedEmail = email,
//                isShowingHomepage = false
//            )
//        }
//    }
//
//    fun resetHomeScreenStates() {
//        _uiState.update {
//            it.copy(
//                currentSelectedEmail = it.mailboxes[it.currentMailbox]?.get(0)
//                    ?: LocalEmailsDataProvider.defaultEmail,
//                isShowingHomepage = true
//            )
//        }
//    }
//
//    fun updateCurrentMailbox(mailboxType: MailboxType) {
//        _uiState.update {
//            it.copy(
//                currentMailbox = mailboxType
//            )
//        }
//    }
//}
