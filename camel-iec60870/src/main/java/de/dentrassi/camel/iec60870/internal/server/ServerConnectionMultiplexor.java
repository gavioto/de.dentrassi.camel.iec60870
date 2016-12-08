/*
 * Copyright (C) 2016 Jens Reimann <jreimann@redhat.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package de.dentrassi.camel.iec60870.internal.server;

import de.dentrassi.camel.iec60870.internal.AbstractConnectionMultiplexor;

public class ServerConnectionMultiplexor extends AbstractConnectionMultiplexor {

	private final ServerInstance server;

	public ServerConnectionMultiplexor(final ServerInstance server) {
		this.server = server;
	}

	@Override
	protected void performStart() throws Exception {
		this.server.start();
	}

	@Override
	protected void performStop() throws Exception {
		this.server.stop();
	}

	public ServerInstance getServer() {
		return this.server;
	}

}
