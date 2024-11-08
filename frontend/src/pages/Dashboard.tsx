import { MdArrowOutward } from "react-icons/md";
import { IoIosArrowBack,IoIosArrowForward } from "react-icons/io";
import { useState } from "react";
import { FiEdit3 } from "react-icons/fi";
import { transactionLinks } from "../utils/transactionLinks";
import TransactionDetail from "../components/TransactionDetail";
function Dashboard() {
  const totalPages= 3;
  const [currentPage,setCurrentPage]= useState(1);
  const [isSelected,setIsSelected]= useState("");
  const handleNext =()=>{
    if(currentPage < totalPages){
      setCurrentPage(currentPage+1)
    }
  }
  const handlePrevious = ()=>{
    if(currentPage >1){
      setCurrentPage(currentPage -1)
    }
  }

  const handleClick =(value:string)=>{
    setIsSelected(value)

  }
  return (
    <div className=" w-full px-3 py-4 flex flex-1 flex-col gap-6">
     {/* Three grid items */}
     <div className="w-full grid grid-cols-1 sm:grid-cols-2 lg:grid-cols-3 gap-4 ">
        <div className="flex flex-col justify-start gap-3">
          <h3 className="text-gray-700 font-inter font-normal text-[22px]">
            Total Balance
          </h3>
          <div className="bg-white flex flex-col gap-4 rounded-[8px] min-h-[200px] flex-grow py-5 px-6">
           
           <div className=" flex justify-between items-center">
            <h3 className="text-dark-1 font-inter font-extrabold text-[22px]">$240,399</h3>
            <p className=" font-inter font-medium text-[14px] text-dark-3">All Accounts</p>
           </div>
           {/* Line */}
           <hr className=" h-[2px] bg-light-gray-2"/>
           <div className=" w-full bg-primary-1 h-auto rounded-[4px] flex justify-between p-4">

            <div className=" flex flex-col gap-1">
              <p className="font-inter font-medium text-[14px] text-gray-6">Account type</p>
              <h3 className="text-white text-[16px] font-bold font-inter">Credit Card</h3>
              <p className="font-inter text-[14px] font-medium text-gray-6">**** **** **** 2598</p>
            </div>
            <div className=" flex flex-col justify-between">
              <img 
               src="/icons/Mastercard.svg" 
               alt="Mastercard"
               width={43}
               height={24}
               />

               <div className=" flex gap-3 items-center">
                <h3 className=" text-white font-inter font-extrabold text-[16px]">$25000</h3>
                <div className=" bg-white h-6 w-6 rounded-full flex justify-center items-center cursor-pointer">
                  <MdArrowOutward size={16} className=" text-primary-1 "/>
                </div>
               </div>
            </div>
           </div>

           {/* Toggle */}

           <div className="flex justify-between items-center">
            
             <p 
             onClick={handlePrevious}
             aria-disabled={currentPage === 1}
             className={`cursor-pointer text-[#D1D1D1] ${currentPage === 1 ? "cursor-not-allowed text-dark-1":"cursor-pointer text-[#D1D1D1]"} flex gap-1 items-center`}>
              <IoIosArrowBack size={20} className=" text-[#D1D1D1]"/> Previous</p>
                 {/* page indicators */}
              
                 <div className="flex items-center gap-2">
                     {[...Array(totalPages)].map((_, index) => (
                  <span
                    key={index}
                    className={`w-2 h-2 rounded-full ${currentPage === index + 1 ? "bg-primary-1" : "bg-gray-300"}`}
                  ></span>
                ))}
              </div>
             <p
             onClick={handleNext}
             aria-disabled={currentPage === totalPages}
              className={` ${currentPage === totalPages ? "cursor-not-allowed text-dark-1":"cursor-pointer text-[#D1D1D1]"}   flex gap-1 items-center`}>
                Next <IoIosArrowForward size={20} className={`${currentPage === totalPages ? "cursor-not-allowed text-dark-1":"cursor-pointer text-[#D1D1D1]"}`}/></p>
            
           </div>
           
          </div>
        </div>
        
        <div className="flex flex-col justify-start gap-3">
          <h3 className="text-gray-700 font-inter font-normal text-[22px]">
            Goals
          </h3>
          <div className="bg-white flex flex-col gap-4 rounded-[8px] p-4 min-h-[200px] flex-grow py-5 px-6">
           
           <div className=" flex justify-between items-center">
            <div className=" flex gap-3 items-center">
              <h3 className="text-dark-1 font-inter font-extrabold text-[22px]">$20,000</h3>
              <div className=" flex items-center justify-center px-2 py-2 rounded-[4px] bg-light-gray-3">
              <FiEdit3 size={24} className=" text-dark-3"/>
              </div>
            </div>
            <p className=" font-inter font-medium text-[14px] text-dark-3">May, 2023</p>
           </div>
           {/* Line */}
           <hr className=" h-[2px] bg-light-gray-2"/>

           <div className=" flex justify-between flex-grow">
             <div className=" flex flex-col justify-between">
              <div className=" flex gap-2">
                <img 
                src="/icons/Award.svg" 
                alt="Award"
                height={24}
                width={24}
                className=" self-start"
                />
                <div className=" flex flex-col gap-2">
                  <p className=" font-inter font-normal text-[14px] text-gray-1">Target Achieved</p>
                  <p className=" font-inter font-bold text-lg">$12,500</p>
                </div>
              </div>
              <div className=" flex gap-2">
                <img 
                src="/icons/octicon_goal-16.svg" 
                alt="Goal"
                height={24}
                width={24}
                className=" self-start"
                />
                <div className=" flex flex-col gap-2">
                  <p className=" font-inter font-normal text-[14px] text-gray-1">This month Target</p>
                  <p className=" font-inter font-bold text-lg">$20,000</p>
                </div>
              </div>

             </div>
           </div>

          </div>
        </div>
        
        <div className="flex flex-col justify-start gap-3">
          <div className=" flex justify-between">
            <h3 className="text-gray-700 font-inter font-normal text-[22px]">
              Upcoming Bill
            </h3>
            <p
              className="cursor-pointer text-gray-1 font-medium text-[16px]  flex gap-1 items-center">
                View All <IoIosArrowForward size={16}/></p>
          </div>
          <div className="bg-white rounded-[8px] p-4 min-h-[200px] flex-grow py-5 px-6 flex flex-col gap-4">
            <div className=" flex justify-between">
              <div className=" flex gap-2">
                <div className=" flex flex-col gap-2 flex-grow bg-light-gray-3 py-3 px-4 rounded-[8px]">
                  <p className=" font-inter text-[14px] font-medium text-[#666666]">May</p>
                  <h3 className=" font-inter font-extrabold text-[22px] text-dark-1">15</h3>
                </div>
                <div className=" flex flex-col flex-grow justify-between">
                  <p className=" text-gray-2">Figma</p>
                  <div className=" flex flex-col gap-1">
                    <h3 className=" font-inter font-bold text-[16px]">Figma - Monthly</h3>
                    <p className=" font-inter font-normal text-[12px] text-light-gray-4">Last Charge - 14 May, 2022</p>
                  </div>
                </div>
              </div>

              <div className=" text-dark-3 font-inter font-bold text-[16px] self-center px-6 py-4 border border-[#E8E8E8] rounded-[8px]">$150</div>
            </div>
            {/* Horizontal line */}
            <hr className=" h-[2px] bg-light-gray-2"/>

            {/* Adobe */}

            <div className=" flex justify-between">
              <div className=" flex gap-2">
                <div className=" flex flex-col gap-2 flex-grow bg-light-gray-3 py-3 px-4 rounded-[8px]">
                  <p className=" font-inter text-[14px] font-medium text-[#666666]">Jun</p>
                  <h3 className=" font-inter font-extrabold text-[22px] text-dark-1">16</h3>
                </div>
                <div className=" flex flex-col flex-grow justify-between">
                  <img 
                   src="/icons/Adobe.svg" 
                   height={16}
                   width={60}
                   alt="" />
                  <div className=" flex flex-col gap-1">
                    <h3 className=" font-inter font-bold text-[16px]">Adobe - Yearly</h3>
                    <p className=" font-inter font-normal text-[12px] text-light-gray-4">Last Charge - 17 Jun, 2023</p>
                  </div>
                </div>
              </div>

              <div className=" text-dark-3 font-inter font-bold text-[16px] self-center px-6 py-4 border border-[#E8E8E8] rounded-[8px]">$559</div>
            </div>
          </div>
        </div>
      </div>


     {/* Transactions,Statistics and expenses breakdown */}
     <div className=" grid grid-cols-3 gap-4 w-full">
      <div className=" flex flex-col gap-2 col-span-1">
        <div className=" flex justify-between">
          <h3 className="font-inter font-normal text-[22px] text-gray-1">Recent Transaction</h3>
          <p
              className="cursor-pointer text-gray-1 font-medium text-[16px]  flex gap-1 items-center">
                View All <IoIosArrowForward size={16}/></p>
        </div>
        <div className="bg-white flex flex-col gap-8 rounded-[8px] min-h-[200px] flex-grow py-5 px-6">
         <ul className=" flex gap-6">
          {transactionLinks.map((link)=>(
          <li 
          onClick={()=>handleClick(link.name)}
          className={` text-gray-3 cursor-pointer font-inter font-bold text-[16px] ${isSelected === link.name ? "active-link text-primary-1":""}`}
          key={link.type}>{link.name}</li>
         
          ))}
         </ul>
         <div className=" flex flex-col gap-4">
          <TransactionDetail
          amount={160.00}
          date="17 May 2023"
          image=""
          itemName="GTR 5"
          shopName="Gadget & Gear"
          
          />
          <hr className=" h-[2px] bg-light-gray-2"/>
          <TransactionDetail
          amount={20.00}
          date="17 May 2023"
          image=""
          itemName="Polo Shirt"
          shopName="XL fashions"
          
          />
          <hr className=" h-[2px] bg-light-gray-2"/>
          <TransactionDetail
          amount={10.00}
          date="17 May 2023"
          image=""
          itemName="Biriyani"
          shopName="Hajir Biriyani"
          
          />
          <hr className=" h-[2px] bg-light-gray-2"/>
          <TransactionDetail
          amount={12.00}
          date="17 May 2023"
          image=""
          itemName="Taxi Fare"
          shopName="Uber"
          
          />
          <hr className=" h-[2px] bg-light-gray-2"/>
          <TransactionDetail
          amount={22.00}
          date="17 May 2023"
          image=""
          itemName="Keyboard"
          shopName="Gadget & Gear"
          
          />
         



         </div>
        </div>
      </div>
      {/* Statistics and Expense breakdown */}

      <div className=""></div>
     </div>
     
    </div>
  )
}

export default Dashboard
