import { Link } from "react-router-dom"
import { sidebarLinks } from "../utils/sidebar-links"
import { useLocation } from "react-router-dom"
const Sidebar = () => {
 
  const {pathname}= useLocation();
  
  return (
    <div className=" bg-dark-1 md:w-64 px-8 py-6 flex  flex-col justify-between">
      <div className=" flex flex-col gap-12">
      <h2 className=" text-white font-inter text-2xl text-center"><span className=" font-bold">FINE</span>bank.<span className=" font-bold">IO</span></h2>

      <ul className=" flex flex-col gap-4">
          {sidebarLinks.map((link)=>{
            const isActive= pathname === link.route
            return(
            <li>
            <Link 
            to={link.route}
            className={`flex gap-4 py-3 px-3 hover:bg-primary-1 rounded-[4px] ${isActive 
              ? "text-white bg-primary-1 ":
               "text-dark-white"} `}
            >
              <img 
              src={link.icon} 
              alt="link icon"
              
              width={24}
              height={24}
              />
               {link.label}</Link>
        </li>
          )})}
      </ul>
      
    </div>
    {/* Logout and user */}

   <div className=" flex flex-col gap-8">
      <button className=" text-white flex gap-4 items-center bg-gray-4 py-3 px-2 font-inter font-semibold
      ">
        <img 
        src="/icons/Logout.svg" 
        alt="Logout"
        height={20}
        width={20}
        />
        Logout</button>

        <hr className=" h-[1px] bg-gray-1 "/>

        <div className=" flex justify-between w-full">
          <div className=" flex gap-2 items-center">
            <img 
             src="/images/profile.png" 
             alt="profile"
             height={32}
             width={32}
             />
             <Link to="/user/profile" className=" flex flex-col">

              <p className=" text-white font-semibold text-[16px] font-inter">Tanzir Rahman</p>
              <p className=" font-inter text-[12px] font-normal text-white ">View Profile</p>
             </Link>
          </div>
          {/* icon */}
          <img 
            src="/icons/Icon.svg" 
            alt="Icon"
            height={24}
            />
        </div>
    </div>
    </div> 
  )
}

export default Sidebar
