import { BrowserRouter as Router, Routes,Route } from 'react-router-dom'
import Home from "./pages/Home"
import AuthLayout from './layout/AuthLayout'
import Login from './pages/Login'
import Signup from './pages/Signup'
import ForgotPassword from './pages/ForgotPassword'

import RootLayout from './layout/RootLayout'
import Dashboard from './pages/Dashboard'
function App() {


  return (
 
    <Router>
      <Routes>
        <Route path="/" element={<Home />} index />

        <Route element={<AuthLayout/>}>
         <Route  path='/auth/login' element={<Login/>} />
         <Route path='/auth/signup' element={<Signup/>}/>
         <Route path='/forgot-password' element={<ForgotPassword/>}/>
        </Route>

        <Route element={<RootLayout/>}>
        <Route path='/dashboard' element={<Dashboard/>}/>

        </Route>
      </Routes>
    </Router>
  
   
  )
}

export default App
