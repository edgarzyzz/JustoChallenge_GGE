package com.gogaedd.edgargonzalezjustochallenge.listener

import com.gogaedd.edgargonzalezjustochallenge.model.Person

interface UserRegsitreredListener {
    fun onUserSelected(user: Person)
}