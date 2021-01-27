package uk.nhs.nhsx.testhelper.mocks

import com.amazonaws.services.s3.model.S3Object
import com.google.common.io.ByteSource
import org.apache.http.entity.ContentType
import uk.nhs.nhsx.core.aws.s3.BucketName
import uk.nhs.nhsx.core.aws.s3.Locator
import uk.nhs.nhsx.core.aws.s3.MetaHeader
import uk.nhs.nhsx.core.aws.s3.ObjectKey
import uk.nhs.nhsx.core.aws.s3.S3Storage
import java.util.*

open class FakeS3Storage : S3Storage {
    var count: Int = 0
    lateinit var bucket: BucketName
    lateinit var name: ObjectKey
    lateinit var contentType: ContentType
    lateinit var bytes: ByteSource
    val meta: MutableList<MetaHeader> = mutableListOf()
    val exists: Optional<S3Object> = Optional.empty()

    override fun upload(locator: Locator,
                        contentType: ContentType,
                        bytes: ByteSource,
                        meta: Array<MetaHeader>) {
        overwriting(locator, contentType, bytes, meta.toList())
    }

    private fun overwriting(locator: Locator,
                            contentType: ContentType,
                            bytes: ByteSource,
                            meta: List<MetaHeader>) {
        count++
        bucket = locator.bucket
        name = locator.key
        this.contentType = contentType
        this.bytes = bytes
        this.meta += meta
    }
}