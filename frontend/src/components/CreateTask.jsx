import { useEffect, useState } from "react"
import { getTask, saveTask, updateTask } from "../services/TaskService"
import { useNavigate, useParams } from "react-router-dom"

const CreateTask = () => {

  const [taskName, setTaskName] = useState('')
  const [description, setDescription] = useState('')
  const [deadline, setDeadline] = useState('')
  const navigate = useNavigate()
  const { id } = useParams()

  function saveUpdateTask(e) {
    e.preventDefault()
    const task = { taskName, description, deadline }
    console.log(task)

    if (id) {
      updateTask(id, task).then((response) => {
        navigate('/tasks')
      }).catch(error => {
        console.error(error)
      })
    } else {
      saveTask(task).then((response) => {
        console.log(response.data)
        navigate('/tasks')
      }).catch(error => {
        console.error(error)
      })
    }

  }

  function pageTitle() {
    if (id) {
      return <h2 className='text-center'>Update Task</h2>
    } else {
      return <h2 className='text-center'>Create Task</h2>
    }
  }

  useEffect(() => {
    if (id) {
      getTask(id).then((response) => {
        console.log(response.data)
        setTaskName(response.data.taskName)
        setDescription(response.data.description)
        setDeadline(response.data.deadline)
      }).catch(error => {
        console.error(error)
      })
    }
  }, [])

  return (
    <div className='container'>
      <br /> <br />
      <div className='row'>
        <div className='card col-md-6 offset-md-3 offset-md-3'>
          {pageTitle()}
          <div className='card-body'>
            <form>
              <div className='form-group mb-2'>
                <label className='form-label'>Task Name:</label>
                <input type='text' placeholder='Enter Task Name...' name='taskName' value={taskName}
                  onChange={(e) => setTaskName(e.target.value)}
                  className='form-control' />
              </div>

              <div className='form-group mb-2'>
                <label className='form-label'>Task Description:</label>
                <input type='text' placeholder='Enter Task Description...' name='description' value={description}
                  onChange={(e) => setDescription(e.target.value)}
                  className='form-control' />
              </div>

              <div className='form-group mb-2'>
                <label className='form-label'>Task Deadline:</label>
                <input type='text' placeholder='Enter Deadline (in weeks, days, date version)...' name='deadline' value={deadline}
                  onChange={(e) => setDeadline(e.target.value)}
                  className='form-control' />
              </div>

              <button className='btn btn-success' onClick={(e) => saveUpdateTask(e)}>Submit</button>
            </form>
          </div>

        </div>
      </div>
    </div>
  )
}

export default CreateTask