<template>
    <v-container>
        <v-snackbar
            v-model="snackbar.status"
            :timeout="snackbar.timeout"
            :color="snackbar.color"
        >
            
            <v-btn style="margin-left: 80px;" text @click="snackbar.status = false">
                Close
            </v-btn>
        </v-snackbar>
        <div class="panel">
            <div class="gs-bundle-of-buttons" style="max-height:10vh;">
                <v-btn @click="addNewRow" @class="contrast-primary-text" small color="primary">
                    <v-icon small style="margin-left: -5px;">mdi-plus</v-icon>등록
                </v-btn>
                <v-btn :disabled="!selectedRow" style="margin-left: 5px;" @click="openEditDialog()" class="contrast-primary-text" small color="primary">
                    <v-icon small>mdi-pencil</v-icon>수정
                </v-btn>
            </div>
            <div class="mb-5 text-lg font-bold"></div>
            <div class="table-responsive">
                <v-table>
                    <thead>
                        <tr>
                        <th>Id</th>
                        <th>PublicationId</th>
                        <th>AuthorName</th>
                        <th>AuthorId</th>
                        <th>Title</th>
                        <th>SummaryText</th>
                        <th>CoverImageUrl</th>
                        <th>ProductRegistered</th>
                        <th>IsPublishCompleted</th>
                        <th>IsBestSeller</th>
                        <th>Status</th>
                        <th>PublishedDate</th>
                        <th>Message</th>
                        <th>GPT API</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr v-for="(val, idx) in value" 
                            @click="changeSelectedRow(val)"
                            :key="val"  
                            :style="val === selectedRow ? 'background-color: rgb(var(--v-theme-primary), 0.2) !important;':''"
                        >
                            <td class="font-semibold">{{ idx + 1 }}</td>
                            <td class="whitespace-nowrap" label="PublicationId">{{ val.publicationId }}</td>
                            <td class="whitespace-nowrap" label="AuthorName">{{ val.authorName }}</td>
                            <td class="whitespace-nowrap" label="AuthorId">{{ val.authorId }}</td>
                            <td class="whitespace-nowrap" label="Title">{{ val.title }}</td>
                            <td class="whitespace-nowrap" label="SummaryText">{{ val.summaryText }}</td>
                            <td class="whitespace-nowrap" label="CoverImageUrl">{{ val.coverImageUrl }}</td>
                            <td class="whitespace-nowrap" label="ProductRegistered">{{ val.productRegistered }}</td>
                            <td class="whitespace-nowrap" label="IsPublishCompleted">{{ val.isPublishCompleted }}</td>
                            <td class="whitespace-nowrap" label="IsBestSeller">{{ val.isBestSeller }}</td>
                            <td class="whitespace-nowrap" label="Status">{{ val.status }}</td>
                            <td class="whitespace-nowrap" label="PublishedDate">{{ val.publishedDate }}</td>
                            <td class="whitespace-nowrap" label="Message">{{ val.message }}</td>
                            <td class="whitespace-nowrap" label="GPT API">
                                <GptApiId :editMode="editMode" v-model="val.gptApiId"></GptApiId>
                            </td>
                            <v-row class="ma-0 pa-4 align-center">
                                <v-spacer></v-spacer>
                                <Icon style="cursor: pointer;" icon="mi:delete" @click="deleteRow(val)" />
                            </v-row>
                        </tr>
                    </tbody>
                </v-table>
            </div>
        </div>
        <v-col>
            <v-dialog
                v-model="openDialog"
                transition="dialog-bottom-transition"
                width="35%"
            >
                <v-card>
                    <v-toolbar
                        color="primary"
                        class="elevation-0 pa-4"
                        height="50px"
                    >
                        <div style="color:white; font-size:17px; font-weight:700;">Service 등록</div>
                        <v-spacer></v-spacer>
                        <v-icon
                            color="white"
                            small
                            @click="closeDialog()"
                        >mdi-close</v-icon>
                    </v-toolbar>
                    <v-card-text>
                        <Service :offline="offline"
                            :isNew="!value.idx"
                            :editMode="true"
                            :inList="false"
                            v-model="newValue"
                            @add="append"
                        />
                    </v-card-text>
                </v-card>
            </v-dialog>
            <v-dialog
                v-model="editDialog"
                transition="dialog-bottom-transition"
                width="35%"
            >
                <v-card>
                    <v-toolbar
                        color="primary"
                        class="elevation-0 pa-4"
                        height="50px"
                    >
                        <div style="color:white; font-size:17px; font-weight:700;">Service 수정</div>
                        <v-spacer></v-spacer>
                        <v-icon
                            color="white"
                            small
                            @click="closeDialog()"
                        >mdi-close</v-icon>
                    </v-toolbar>
                    <v-card-text>
                        <div>
                            <Number label="PublicationId" v-model="selectedRow.publicationId" :editMode="true"/>
                            <String label="AuthorName" v-model="selectedRow.authorName" :editMode="true"/>
                            <Number label="AuthorId" v-model="selectedRow.authorId" :editMode="true"/>
                            <String label="Title" v-model="selectedRow.title" :editMode="true"/>
                            <String label="SummaryText" v-model="selectedRow.summaryText" :editMode="true"/>
                            <String label="CoverImageUrl" v-model="selectedRow.coverImageUrl" :editMode="true"/>
                            <String label="ProductRegistered" v-model="selectedRow.productRegistered" :editMode="true"/>
                            <Boolean label="IsPublishCompleted" v-model="selectedRow.isPublishCompleted" :editMode="true"/>
                            <String label="IsBestSeller" v-model="selectedRow.isBestSeller" :editMode="true"/>
                            <String label="Status" v-model="selectedRow.status" :editMode="true"/>
                            <Date label="PublishedDate" v-model="selectedRow.publishedDate" :editMode="true"/>
                            <String label="Message" v-model="selectedRow.message" :editMode="true"/>
                            <v-divider class="border-opacity-100 my-divider"></v-divider>
                            <v-layout row justify-end>
                                <v-btn
                                    width="64px"
                                    color="primary"
                                    @click="save"
                                >
                                    수정
                                </v-btn>
                            </v-layout>
                        </div>
                    </v-card-text>
                </v-card>
            </v-dialog>
        </v-col>
    </v-container>
</template>

<script>
import { ref } from 'vue';
import { useTheme } from 'vuetify';
import BaseGrid from '../base-ui/BaseGrid.vue'


export default {
    name: 'serviceGrid',
    mixins:[BaseGrid],
    components:{
    },
    data: () => ({
        path: 'services',
    }),
    watch: {
    },
    methods:{
    }
}

</script>