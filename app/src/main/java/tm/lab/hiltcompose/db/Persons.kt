package tm.lab.hiltcompose.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Persons(
   @PrimaryKey(autoGenerate = true)
   val id : Long = 0,
   @ColumnInfo(name = "name")
   val name : String,
   @ColumnInfo(name = "age")
   val age : Int
) {}