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

package de.dentrassi.camel.iec60870.client;

import java.util.Objects;

import org.apache.camel.spi.UriParam;
import org.apache.camel.spi.UriParams;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.neoscada.protocol.iec60870.ProtocolOptions;
import org.eclipse.neoscada.protocol.iec60870.client.data.DataModuleOptions;

import de.dentrassi.camel.iec60870.BaseOptions;

@UriParams
public class ClientOptions extends BaseOptions<ClientOptions> {

	/**
	 * Data module options
	 */
	@UriParam(javaType = "DataModuleOptions")
	private DataModuleOptions.Builder dataModuleOptions;

	public ClientOptions() {
		this.dataModuleOptions = new DataModuleOptions.Builder();
	}

	public ClientOptions(final ClientOptions other) {
		this(other.getProtocolOptions(), other.getDataModuleOptions());
	}

	public ClientOptions(final ProtocolOptions protocolOptions, final DataModuleOptions dataOptions) {
		super(protocolOptions);

		Objects.requireNonNull(dataOptions);

		this.dataModuleOptions = new DataModuleOptions.Builder(dataOptions);
	}

	public void setDataModuleOptions(final DataModuleOptions dataModuleOptions) {
		Objects.requireNonNull(dataModuleOptions);

		this.dataModuleOptions = new DataModuleOptions.Builder(dataModuleOptions);
	}

	public DataModuleOptions getDataModuleOptions() {
		return this.dataModuleOptions.build();
	}

	@Override
	public @NonNull ClientOptions copy() {
		return new ClientOptions(this);
	}

	// wrapper methods - DataModuleOptions

	public void setCauseSourceAddress(final Byte causeSourceAddress) {
		this.dataModuleOptions.setCauseSourceAddress(causeSourceAddress);
	}

	public Byte getCauseSourceAddress() {
		return this.dataModuleOptions.getCauseSourceAddress();
	}

	public void setIgnoreBackgroundScan(final boolean ignoreBackgroundScan) {
		this.dataModuleOptions.setIgnoreBackgroundScan(ignoreBackgroundScan);
	}

	public boolean isIgnoreBackgroundScan() {
		return this.dataModuleOptions.isIgnoreBackgroundScan();
	}
}
