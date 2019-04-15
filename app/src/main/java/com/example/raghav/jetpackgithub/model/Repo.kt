package com.example.raghav.jetpackgithub.model

import android.view.View
import androidx.room.*
import com.example.raghav.jetpackgithub.ui.customview.CustomBottomSheetDialog
import com.example.raghav.jetpackgithub.util.convertTimeFormat

@Entity(
        tableName = "repos",
        foreignKeys = [ForeignKey(entity = User::class, parentColumns = ["id"], childColumns = ["user_id"])],
        indices = [Index("user_id")]
)
data class Repo(
        @ColumnInfo(name = "user_id") val userId: String,
        val name: String,
        val description: String,
        val updated_at: String,
        val stargazers_count: Int,
        val forks: Int
) {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var repoId: Long = 0

    fun listItemClicked(view: View) {
        /*
        Show details of the selected repo using a custom bottom sheet dialog.
        It provides the requisite animations.
         */
        val customBottomSheetDialog = CustomBottomSheetDialog(view.context,
                convertTimeFormat(updated_at),
                stargazers_count.toString(),
                forks.toString())
        customBottomSheetDialog.show()
    }
}