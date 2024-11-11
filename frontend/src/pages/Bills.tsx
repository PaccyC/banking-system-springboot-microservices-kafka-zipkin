


const billsList =[
  {
    "date":"15",
    "month":"May",
    "logo":"/icons/Adobe.svg",
    "item_description":"For Advanced security  and more flexible controls, the Professional plan helps you scale design processes world wide",
    "description_title":"Figma- Yearly Plan",
    "last_change":"14 May, 2022",
    "amount":150
  },
  {
    "date":"15",
    "month":"May",
    "logo":"/icons/Adobe.svg",
    "item_description":"For Advanced security  and more flexible controls, the Professional plan helps you scale design processes world wide",
    "description_title":"Figma- Yearly Plan",
    "last_change":"14 May, 2022",
    "amount":150
  }
]
const Bills = () => {
  return (
    <div className=" flex flex-col gap-4 w-full">
      <h3 className=" font-inter font-normal text-[22px] text-gray-1">Upcoming Bills</h3>

      <div className="w-full bg-white rounded-[8px] min-h-[200px] px-4 py-4">

        <table className=" w-full">
          <thead>
            <tr className="">
              <th className="px-4 py-2 text-dark-1 font-inter text-[20px] text-start">Due Date</th>
              <th className="px-4 py-2 text-dark-1 font-inter text-[20px] text-start">Logo</th>
              <th className="px-4 py-2 text-dark-1 font-inter text-[20px] text-start">Item Description</th>
              <th className="px-4 py-2 text-dark-1 font-inter text-[20px] text-center">Last Change</th>
              <th className="px-4 py-2 text-dark-1 font-inter text-[20px] text-center">Amount</th>
            </tr>
          </thead>
          <tbody>
            {billsList.map((bill)=>(
              <tr className="">
                <td className="px-4 py-6 text-gray-1 text-[16px] font-inter font-medium items-center">
                  <div className="flex flex-col w-[80px] items-center justify-center bg-light-gray px-4 py-5 rounded-[4px]">
                    <p className="">{bill.month}</p>
                    <h3 className="text-dark-1 font-bold text-[24px] ">{bill.date}</h3>

                  </div>
                </td>
                <td className=" items-center">
                  <img 
                  src={bill.logo} 
                  
                  alt="" />
                </td>
                <td className=" flex flex-col gap-2">
                  <h3 className=" text-3xl font-bold font-inter text-dark-1">{bill.description_title}</h3>
                  <p className=" text-gray-1 max-w-[400px] leading-relaxed">{bill.item_description}</p>
                </td>
                <td className="px-4 py-2 text-dark-1 text-[16px] font-inter font-semibold text-center">{bill.last_change}</td>
                <td className="px-4 py-2 text-dark-1 text-[16px] font-inter font-semibold text-center">
                  <div className=" px-6 py-4 border-[2px] rounded-[8px] border-gray-3">
                  ${bill.amount}
                  </div>
                </td>
              </tr>
            ))}
          </tbody>
        </table>
      </div>
    </div>
  )
}

export default Bills