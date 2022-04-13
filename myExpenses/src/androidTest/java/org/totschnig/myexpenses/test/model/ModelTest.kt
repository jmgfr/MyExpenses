package org.totschnig.myexpenses.test.model

import android.content.ContentUris
import org.mockito.Mockito
import org.totschnig.myexpenses.db2.Repository
import org.totschnig.myexpenses.model.CurrencyContext
import org.totschnig.myexpenses.model.Model
import org.totschnig.myexpenses.testutils.BaseProviderTest
import org.totschnig.myexpenses.viewmodel.data.Category2

abstract class ModelTest : BaseProviderTest() {
    protected val repository: Repository
        get() = Repository(
            mockContentResolver,
            Mockito.mock(CurrencyContext::class.java)
        )

    fun writeCategory(label: String, parentId: Long?) =
        ContentUris.parseId(repository.saveCategory(Category2(label = label, parentId = parentId))!!)

    @Throws(Exception::class)
    override fun setUp() {
        super.setUp()
        Model.setContentResolver(mockContentResolver)
    }
}