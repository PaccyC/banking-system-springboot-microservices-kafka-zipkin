import { useLocation } from "react-router-dom";

const TopBar = () => {
  const {pathname}= useLocation();
  

  return (
    <div className="w-full hidden  lg:flex justify-between items-center px-4 h-[88px] border border-b-[1px] border-b-gray-5 bg-[#F4f5f7]">
      <div className=" flex gap-3 items-center">
        {pathname === "/dashboard" &&
         <h3 className=" text-dark-1 font-inter font-bold text-2xl">Hello Tanzir</h3>
        }
       
        <div className=" flex gap-1 items-center">
            <img 
            src="/icons/chevrons-right.svg" 
            alt="" 
            height={24}
            width={24}
            />
            <span className=" font-inter font-normal text-[14px] text-[#9F9F9F]">May 19, 2023</span>
        </div>

      </div>

    {/* Notification and search input */}
      <div className=" flex gap-4 items-center">
          <img src="/icons/notification_available.svg" width={24} height={24}/>
        

          <div className=" px-3 bg-white flex gap-2 items-center h-[48px] w-auto py-2 rounded-[12px]">
            <input 
            type="text" 
            placeholder="Search here"
            className=" hover:border-none focus:border-none focus:border-gray-2 h-full px-3 font-inter text-[#9F9F9F]"/>

            <img 
             src="/icons/search.svg" 
             alt="Search"
             height={24}
             width={24}
             />
          </div>
      </div>
      
    </div>
  )
}

export default TopBar