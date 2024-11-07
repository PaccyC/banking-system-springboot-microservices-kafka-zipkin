import { Outlet } from "react-router-dom"
import Sidebar from "../components/Sidebar"
import TopBar from "../components/TopBar"
const RootLayout = () => {
  return (
    <div className=" w-full min-h-screen md:flex ">

      <Sidebar/>
      <TopBar/>
      <main className="w-full px-4 bg-secondary h-full flex flex-1">
        <Outlet/>
      </main>
      
    </div>
  )
}

export default RootLayout
