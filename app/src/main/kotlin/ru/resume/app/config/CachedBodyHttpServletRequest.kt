package ru.resume.app.config

import jakarta.servlet.ReadListener
import jakarta.servlet.ServletInputStream
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletRequestWrapper
import java.io.BufferedReader
import java.io.ByteArrayInputStream
import java.io.InputStreamReader

/**
 * Use this class for cache body in Filters
 */
class CachedBodyHttpServletRequest(request: HttpServletRequest) : HttpServletRequestWrapper(request) {
    private val cachedBody: ByteArray

    init {
        cachedBody = request.inputStream.readBytes()
    }

    override fun getInputStream(): ServletInputStream {
        return CachedBodyServletInputStream(cachedBody)
    }

    override fun getReader(): BufferedReader {
        return BufferedReader(InputStreamReader(inputStream))
    }

    private class CachedBodyServletInputStream(cachedBody: ByteArray) : ServletInputStream() {
        private val byteArrayInputStream = ByteArrayInputStream(cachedBody)

        override fun read(): Int = byteArrayInputStream.read()
        override fun isFinished(): Boolean = byteArrayInputStream.available() == 0
        override fun isReady(): Boolean = true
        override fun setReadListener(listener: ReadListener) { throw UnsupportedOperationException("Not implemented") }
    }
}