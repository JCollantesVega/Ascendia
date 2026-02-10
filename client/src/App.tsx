import MentorGrid from './features/mentors/components/MentorGrid'
import { mentorCards } from './features/mentors/mocks/mentorData'
import './App.css'

function App() {

  return (
    <>
      {<MentorGrid mentors={mentorCards}/>}      
    </>
  )
}

export default App
