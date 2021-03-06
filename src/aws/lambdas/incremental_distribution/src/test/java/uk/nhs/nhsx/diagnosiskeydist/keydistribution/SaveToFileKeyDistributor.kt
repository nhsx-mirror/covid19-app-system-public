package uk.nhs.nhsx.diagnosiskeydist.keydistribution

import uk.nhs.nhsx.core.aws.s3.BucketName
import uk.nhs.nhsx.core.aws.s3.ObjectKey
import java.io.File
import java.io.IOException

class SaveToFileKeyDistributor(private val distributionOutputDir: File) : KeyDistributor {

    @Throws(IOException::class)
    override fun distribute(name: BucketName, key: ObjectKey, binFile: File, sigFile: File) {
        val zipFile = File(distributionOutputDir, key.value)
        zipFile.parentFile.mkdirs()
        KeyFileUtility.zipFiles(zipFile, binFile, sigFile)
    }
}
