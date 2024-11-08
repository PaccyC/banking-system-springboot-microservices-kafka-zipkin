import { Outlet } from "react-router-dom"
import Sidebar from "../components/Sidebar"
import TopBar from "../components/TopBar"
const RootLayout = () => {
  return (
    <div className="w-full min-h-screen flex">
      <Sidebar />
      <div className="flex flex-col w-full">
        <TopBar />
        <main className="w-full px-4 py-6 h-full flex flex-1 bg-[#F4f5f7]">
          <Outlet />
        </main>
      </div>
    </div>
  )
}

export default RootLayout
