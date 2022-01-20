package com.mudrax.new7minuteworkout

object Constants {

    fun defaultExerciseList(): ArrayList<ExerciseModel>
    {
        val listOfExercises:ArrayList<ExerciseModel> = ArrayList<ExerciseModel>()

        val jumpingJacks = ExerciseModel(1, "Jumping Jacks" , R.drawable.ic_jumping_jacks)
        val crunches = ExerciseModel(2,"Abdominal Crunches" , R.drawable.ic_abdominal_crunch)
        val highKnees = ExerciseModel(3, "High Knees" , R.drawable.ic_high_knees_running_in_place)
        val lunges = ExerciseModel(4, "Lunges" , R.drawable.ic_lunge)
        val planks = ExerciseModel(5, "Planks" , R.drawable.ic_plank)
        val pushUp = ExerciseModel(6,"Push-Ups" , R.drawable.ic_push_up)
        val rotationPushUps = ExerciseModel(7 , "Rotational Push-ups" , R.drawable.ic_push_up_and_rotation)
        val sidePlanks = ExerciseModel(8,"Side Planks" , R.drawable.ic_side_plank)
        val squat = ExerciseModel(9 , "Squats" , R.drawable.ic_squat)
        val steps = ExerciseModel(10 , "Steps On Chair" , R.drawable.ic_step_up_onto_chair)
        val dips =ExerciseModel(11, "Triceps Dips" , R.drawable.ic_triceps_dip_on_chair)
        val wallSit = ExerciseModel(12 , "Wall sit Hold" ,R.drawable.ic_wall_sit)

        listOfExercises.add(jumpingJacks)
        listOfExercises.add(crunches)
        listOfExercises.add(highKnees)
        listOfExercises.add(lunges)
        listOfExercises.add(planks)
        listOfExercises.add(pushUp)
        listOfExercises.add(rotationPushUps)
        listOfExercises.add(sidePlanks)
        listOfExercises.add(squat)
        listOfExercises.add(steps)
        listOfExercises.add(dips)
        listOfExercises.add(wallSit)

        return listOfExercises
    }
}