import { ExploreMentors } from './pages/ExploreMentors'
import MentorDetail from './pages/MentorDetail'
import './App.css'
import { Routes, Route, BrowserRouter } from 'react-router'

function App() {

  

  return (
    <>
    <BrowserRouter>
      <Routes>
        <Route path="/" element={<ExploreMentors/>}></Route>
        <Route path='/mentor/:id' element={<MentorDetail/>}></Route>
      </Routes>  
    </BrowserRouter>
    </>
  )
}

export default App
