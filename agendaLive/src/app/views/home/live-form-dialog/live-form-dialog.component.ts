import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { MatDialogRef } from '@angular/material/dialog';
import { LiveService } from 'src/app/shared/service/live.service';
import * as moment from 'moment';

@Component({
  selector: 'app-live-form-dialog',
  templateUrl: './live-form-dialog.component.html',
  styleUrls: ['./live-form-dialog.component.css']
})
export class LiveFormDialogComponent implements OnInit {

  public formGroup: FormGroup;

  constructor(
    private formBuilder: FormBuilder,
    public dialogRef: MatDialogRef<LiveFormDialogComponent>,
    private liveService: LiveService

  ) { }

  ngOnInit(): void {
    this.formGroup = this.formBuilder.group({

      liveName: ['', [Validators.required]],
      channelName: ['', [Validators.required]],
      liveLink: ['', [Validators.required]],
      liveDate: ['', [Validators.required]],
      liveTime: ['', [Validators.required]]

    });
  }
  liveCreate() {
    let newDate: moment.Moment = moment.utc(this.formGroup.value.liveDate).local();
    this.formGroup.value.liveDate = newDate.format("YYYY-MM-DD") + 'T' + this.formGroup.value.liveTime;
    this.liveService.postLives(this.formGroup.value).subscribe(result => {});
    console.log(this.formGroup.value);
    this.dialogRef.close();
    this.formGroup.reset();
    window.location.reload();

  }

  cancel(): void {
    this.dialogRef.close();
    this.formGroup.reset();

  }

}
