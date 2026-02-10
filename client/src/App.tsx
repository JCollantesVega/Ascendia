import { useState } from 'react'
import MentorCard from './features/mentors/components/MentorCard'
import { mentorCards } from './features/mentors/mocks/mentorData'
import './App.css'

function App() {
  const [count, setCount] = useState(0)

  return (
    <>
      <MentorCard {...mentorCards[1]}/>
    </>
  )
}

export default App
