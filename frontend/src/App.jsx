import './App.css'
import Footer from './components/Footer'
import Header from './components/Header'
import TaskList from './components/TaskList'
import { BrowserRouter, Routes, Route } from 'react-router-dom'
import CreateTask from './components/CreateTask'

function App() {

  return (
    <>
      <BrowserRouter>
        <Header />
        <Routes>
          <Route path='/' element={<TaskList />} />
          <Route path='/tasks' element={<TaskList />} />
          <Route path='/create-task' element={<CreateTask />} />
          <Route path='/update-task/:id' element={<CreateTask />} />
        </Routes>
        <Footer />
      </BrowserRouter>
    </>
  )
}

export default App
