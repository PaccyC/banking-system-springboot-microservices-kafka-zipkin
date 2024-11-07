import { BrowserRouter as Router, Routes,Route } from 'react-router-dom'
import Home from "./pages/Home"
import AuthLayout from './layout/AuthLayout'
import Login from './pages/Login'
import Signup from './pages/Signup'
function App() {


  return (
 
    <Router>
      <Routes>
        <Route path="/" element={<Home />} index />

        <Route element={<AuthLayout/>}>
         <Route  path='/auth/login' element={<Login/>} />
         <Route path='/auth/signup' element={<Signup/>}/>
          
        </Route>
      </Routes>
    </Router>
  
   
  )
}

export default App
