import { useEffect, useState } from "react"
import { getAllTasks, deleteTask } from "../services/TaskService"
import { useNavigate } from "react-router-dom"

const TaskList = () => {

    const [tasks, setTasks] = useState([])
    const navigate = useNavigate()

    useEffect(() => {
        listTasks()
    }, [])

    function listTasks() {
        getAllTasks().then((response) => {
            setTasks(response.data)
        }).catch(error => {
            console.error(error)
        })
    }

    function addNewTask() {
        navigate('/create-task')
    }

    function updateTask(id) {
        console.log(id)
        navigate(`/update-task/${id}`)
    }

    function removeTask(id) {
        deleteTask(id).then((response) => {
            listTasks()
        }).catch(error => {
            console.error(error)
        })
    }

    return (
        <div className='container'>
            <h2 className='text-center'>List of Tasks</h2>
            <button className='btn btn-primary mb-2' onClick={addNewTask}>Create Task</button>
            <div>
                <table className='table table-bordered table-striped'>
                    <thead>
                        <tr>
                            <th>Task Name</th>
                            <th>Description</th>
                            <th>Deadline</th>
                            <th>Actions</th>
                        </tr>
                    </thead>
                    <tbody>
                        {
                            tasks.map(task =>
                                <tr key={task.id}>
                                    <td>{task.taskName}</td>
                                    <td>{task.description}</td>
                                    <td>{task.deadline}</td>
                                    <td>
                                        <button className='btn btn-info' onClick={() => updateTask(task.id)}>Update</button>
                                        <button className='btn btn-danger' onClick={() => removeTask(task.id)}>Delete</button>
                                    </td>
                                </tr>
                            )
                        }
                    </tbody>
                </table>
            </div>
        </div>
    )
}

export default TaskList