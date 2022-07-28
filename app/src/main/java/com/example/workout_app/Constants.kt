package com.example.workout_app

object Constants {


    fun exerciselistmodel():ArrayList<ExerciseLists>{

        val exerciseList=ArrayList<ExerciseLists>()



        val jumping_jack=ExerciseLists(1,"Jumping Jack",
            R.drawable.ic_jumping_jacks,false,false)
        exerciseList.add(jumping_jack)

        val abdominal_crunch=ExerciseLists(2,"Abdominal Crunch",
            R.drawable.ic_abdominal_crunch,false,false)
        exerciseList.add(abdominal_crunch)

        val high_knees_running=ExerciseLists(3,"High Knees Running in Place",
            R.drawable.ic_high_knees_running_in_place,false,false)
        exerciseList.add(high_knees_running)

        val lunge=ExerciseLists(4,"Lunge",
            R.drawable.ic_lunge,false,false)
        exerciseList.add(lunge)

        val plank=ExerciseLists(5,"Plank",
            R.drawable.ic_plank,false,false)
        exerciseList.add(plank)


        val push_up=ExerciseLists(6,"Push Up",
            R.drawable.ic_push_up,false,false)
        exerciseList.add(push_up)

        val push_up_rotation=ExerciseLists(7,"Push Up And Rotation",
            R.drawable.ic_push_up_and_rotation,false,false)
        exerciseList.add(push_up_rotation)

        val side_plank=ExerciseLists(8,"Side Plank",
            R.drawable.ic_side_plank,false,false)
        exerciseList.add(side_plank)

        val squat=ExerciseLists(9,"Squat",
            R.drawable.ic_squat,false,false)
        exerciseList.add(squat)

        val step_up_chair=ExerciseLists(10,"Step Up Onto Chair",
            R.drawable.ic_step_up_onto_chair,false,false)
        exerciseList.add(step_up_chair)

        val triceps=ExerciseLists(11,"Triceps dip on Chair",
            R.drawable.ic_triceps_dip_on_chair,false,false)
        exerciseList.add(triceps)

        val wall_sit=ExerciseLists(12,"Wall Sit",
            R.drawable.ic_wall_sit,false,false)
        exerciseList.add(wall_sit)







        return exerciseList
    }
}