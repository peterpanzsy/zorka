/**
 * Copyright 2012 Rafal Lewczuk <rafal.lewczuk@jitlogic.com>
 *
 * ZORKA is free software. You can redistribute it and/or modify it under the
 * terms of the GNU General Public License as published by the Free Software
 * Foundation, either version 3 of the License, or (at your option) any later
 * version.
 *
 * ZORKA is distributed in the hope that it will be useful, but WITHOUT ANY
 * WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU General Public License for more
 * details.
 *
 * You should have received a copy of the GNU General Public License along with
 * ZORKA. If not, see <http://www.gnu.org/licenses/>.
 */

package com.jitlogic.zorka.mbeans;

import java.util.HashMap;
import java.util.Map;

public class MethodCallStatistics implements ZorkaStats {

	private Map<String, MethodCallStatistic> stats = new HashMap<String, MethodCallStatistic>();

	
	public synchronized ZorkaStat getStatistic(String statisticName) {
		return stats.get(statisticName);
	}
	
	
	public synchronized String[] getStatisticNames() {
		String[] names = new String[stats.size()];
		
		int i = 0; 

		for (String name : stats.keySet()) {
			names[i++] = name;
		}
		
		return names;
	}


	public synchronized MethodCallStat getMethodCallStatistic(String name) {
		MethodCallStatistic ret = stats.get(name);
		
		if (ret == null) {
			ret = new MethodCallStatistic(name);
			stats.put(name,  ret);
		}
		
		return ret;
	}

	public synchronized void clear() {
		stats.clear();
	}
}