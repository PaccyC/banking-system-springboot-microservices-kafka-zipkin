import { StatisticsChart } from "../charts/StatisticsChart"

const Expenses = () => {
  return (
    <div className="w-full flex flex-col gap-6">
      <div className="flex flex-col gap-4">
        <h3 className="font-inter font-normal text-[22px] text-gray-1">Expenses Comparison</h3>
        <div className="bg-white  rounded-[8px] min-h-[200px] py-5 px-6 max-h-[400px]">

          <StatisticsChart />

        </div>

      </div>
      <div className=" flex flex-col gap-4">
        <h3 className="font-inter font-normal text-[22px] text-gray-1">Expenses Breakdown</h3>

      </div>
    </div>
  )
}

export default Expenses