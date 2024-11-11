import { useState } from "react"
import { GoalsChart } from "../charts/GoalsChart"
import { FiChevronDown, FiEdit3 } from "react-icons/fi"
import { SavingSummaryChart } from "../charts/SavingSummaryChart"
import ExpenseCategory from "../components/ExpenseCategory"
import AdjustGoal from "../components/AdjustGoal"

const Goals = () => {
  const [isModalOpen,setIsModalOpen]= useState(false)
  return (
    <div className=" flex flex-col gap-6 w-full relative">
    <div className=" flex flex-col gap-4 w-full">
       <h3 className="font-inter font-normal text-[22px] text-gray-1">Goals</h3>
       <div className=" w-full grid grid-cols-3 gap-6 ">
       <div className="bg-white flex flex-col gap-4 rounded-[8px] p-4 min-h-[200px] flex-grow py-5 px-6">
           
           <div className=" flex justify-between items-center">
          
              <h3 className="text-dark-2 font-inter font-extrabold text-[22px]">Savings Goal</h3>
              <div className=" px-4 py-2 bg-light-gray border border-light-gray-5 rounded-[4px] flex gap-3 items-center">
                <p className=" text-dark-3">01 May ~ 31 May</p>
                <FiChevronDown className=" text-dark-3 cursor-pointer" size={24}/>
              </div>

           </div>
           {/* Line */}
           <hr className=" h-[2px] bg-light-gray-2"/>

           <div className=" flex justify-between flex-grow">
             <div className=" flex flex-col gap-10">
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
             <GoalsChart/>
           </div>
           <button className=" border-[2px] border-primary-1 rounded-[8px] px-8 py-2 self-center text-primary-1 font-semibold font-inter  flex items-center">
            Adjust Goal 
            <FiEdit3 className=" text-primary-1 ml-3"/>
           </button>

          </div>
        <div className="bg-white min-h-[200px] rounded-[8px] shadow-lg col-span-2 p-6">
          <SavingSummaryChart/>
        </div>
       </div>

    </div>
    <div className=" flex flex-col gap-4">
      <h3 className="font-inter font-normal text-[22px] text-gray-1">Expenses Goals by Category</h3>
      <div className=" w-full grid grid-cols-3 gap-6 flex-grow">
        <ExpenseCategory
          handleClick={()=>setIsModalOpen(true)}
          categoryName="Housing"
          totalAmount={250.00}
          descriptionImage="/icons/Housing.svg"
        />
         <ExpenseCategory
         handleClick={()=>setIsModalOpen(true)}
          categoryName="Housing"
          totalAmount={250.00}
          descriptionImage="/icons/Housing.svg"
        />
         <ExpenseCategory
         handleClick={()=>setIsModalOpen(true)}
          categoryName="Housing"
          totalAmount={250.00}
          descriptionImage="/icons/Housing.svg"
        />
         <ExpenseCategory
         handleClick={()=>setIsModalOpen(true)}
          categoryName="Housing"
          totalAmount={250.00}
          descriptionImage="/icons/Housing.svg"
        />
         <ExpenseCategory
         handleClick={()=>setIsModalOpen(true)}
          categoryName="Housing"
          totalAmount={250.00}
          descriptionImage="/icons/Housing.svg"
        />
         <ExpenseCategory
         handleClick={()=>setIsModalOpen(true)}
          categoryName="Housing"
          totalAmount={250.00}
          descriptionImage="/icons/Housing.svg"
        />
        
      </div>
    </div>

     {isModalOpen && 
       <AdjustGoal
        closeModal={()=>setIsModalOpen(false)}
       />
     }
   
    </div>
  )
}

export default Goals