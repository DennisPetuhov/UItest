package com.example.ui.DATA.Api

data class StatusModel<out V>(
    val status: Status,
    val message: String?,
    val data: V?

) {
    companion object {
        fun <V> sucsess(data: V?): StatusModel<V> {
            return StatusModel(Status.SUCCESS,null, data)

        }
        fun <V> error(message: String?): StatusModel<V> {
            return StatusModel(Status.ERROR, message, null)

        }
        fun <V> loading (): StatusModel<V> {
            return StatusModel(Status.LOADING, null, null)

        }
    }


}

enum class Status {
    SUCCESS,
    ERROR,
    LOADING
}