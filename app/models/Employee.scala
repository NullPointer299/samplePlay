package models

import java.util.Date

case class Employee(
                     id: Int,
                     userId: String,
                     lastName: String,
                     firstName: String,
                     mailAddress: String,
                     hireDate: Date
                   )
