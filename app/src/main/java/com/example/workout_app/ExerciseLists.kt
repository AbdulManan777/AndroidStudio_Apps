package com.example.workout_app

class ExerciseLists (

    private var eid:Int,
    private var name:String,
    private var img:Int,

    private var isCompleted:Boolean,
    private var isSelected:Boolean)
{

 fun getID():Int{

     return this.eid
 }

    fun setID(id:Int){

        this.eid=id

    }



    fun getname():String{

        return this.name
    }

    fun setName(name:String){

        this.name=name

    }



    fun getImg():Int{

        return this.img
    }

    fun setImg(img:Int){

        this.img=img

    }



    fun getIsSelected():Boolean{

        return this.isSelected
    }

   fun setIsSelected(isSelected:Boolean){

        this.isSelected=isSelected

    }

    fun getIsCompleted():Boolean{

        return this.isCompleted
    }

    fun setIsCompleted(isCompleted:Boolean){

        this.isCompleted=isCompleted

    }


}