import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.gamehokassignment.ui.OverviewFragment
import com.example.gamehokassignment.ui.PlayersFragment
import com.example.gamehokassignment.ui.RulesFragment
import com.example.gamehokassignment.ui.StandingsFragment

class TournamentDetailsPagerAdapter(fragmentActivity: FragmentActivity) : FragmentStateAdapter(fragmentActivity) {

    override fun getItemCount(): Int = 4 // Number of fragments

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> OverviewFragment()
            1 -> StandingsFragment()
            2 -> RulesFragment()
            3 -> PlayersFragment()
            else -> throw IllegalStateException("Invalid position: $position")
        }
    }
}
